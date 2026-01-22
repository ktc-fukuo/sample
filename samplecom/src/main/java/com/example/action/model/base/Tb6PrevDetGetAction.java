package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6PrevDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 前世明細照会
 *
 * @author emarfkrow
 */
public class Tb6PrevDetGetAction extends BaseAction {

    /** 前世明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("Tb6PrevDet.prevId");
        }
        if (prevId == null) {
            isAllKey = false;
        }

        Object prevBn = postJson.get("prevBn");
        if (prevBn == null) {
            prevBn = postJson.get("Tb6PrevDet.prevBn");
        }
        if (prevBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb6Prev tb6Prev = com.example.entity.Tb6Prev.get(prevId);
        map.put("Tb6Prev", tb6Prev);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6PrevDet tb6PrevDet = Tb6PrevDet.get(prevId, prevBn);
            map.put("Tb6PrevDet", tb6PrevDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
