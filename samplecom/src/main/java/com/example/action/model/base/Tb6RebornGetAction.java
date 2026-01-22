package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 転生照会
 *
 * @author emarfkrow
 */
public class Tb6RebornGetAction extends BaseAction {

    /** 転生照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb6Reborn.rebornId");
        }
        if (rebornId == null) {

            Tb6Reborn tb6Reborn = new Tb6Reborn();

            // 転生先になる場合は転生元から情報をコピー
            Object prevId1 = postJson.get("prevId");
            if (prevId1 == null) {
                prevId1 = postJson.get("Tb6Reborn.prevId");
            }
            if (prevId1 != null) {
                com.example.entity.Tb6Prev tb6Prev = com.example.entity.Tb6Prev.get(prevId1);
                tb6Reborn.setPrevId(tb6Prev.getPrevId());
                tb6Reborn.setPrevInfo(tb6Prev.getPrevInfo());
                tb6Prev.referTb6PrevDets();
                tb6Reborn.setTb6RebornDets(new java.util.ArrayList<com.example.entity.Tb6RebornDet>());
                for (com.example.entity.Tb6PrevDet tb6PrevDet : tb6Prev.referTb6PrevDets()) {
                    com.example.entity.Tb6RebornDet tb6RebornDet = new com.example.entity.Tb6RebornDet();
                    tb6RebornDet.setId(tb6PrevDet.getId());
                    tb6RebornDet.setDetInfo(tb6PrevDet.getDetInfo());
                    tb6Reborn.getTb6RebornDets().add(tb6RebornDet);
                }

            }

            map.put("Tb6Reborn", tb6Reborn);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Reborn tb6Reborn = Tb6Reborn.get(rebornId);
            // 子
            tb6Reborn.referTb6RebornDets();
            map.put("Tb6Reborn", tb6Reborn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
