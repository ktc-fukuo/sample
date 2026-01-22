package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6RebornDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 転生明細照会
 *
 * @author emarfkrow
 */
public class Tb6RebornDetGetAction extends BaseAction {

    /** 転生明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb6RebornDet.rebornId");
        }
        if (rebornId == null) {
            isAllKey = false;
        }

        Object rebornBn = postJson.get("rebornBn");
        if (rebornBn == null) {
            rebornBn = postJson.get("Tb6RebornDet.rebornBn");
        }
        if (rebornBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb6Reborn tb6Reborn = com.example.entity.Tb6Reborn.get(rebornId);
        map.put("Tb6Reborn", tb6Reborn);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6RebornDet tb6RebornDet = Tb6RebornDet.get(rebornId, rebornBn);
            map.put("Tb6RebornDet", tb6RebornDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
