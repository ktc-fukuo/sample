package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb3Trans;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 変遷照会
 *
 * @author emarfkrow
 */
public class Tb3TransGetAction extends BaseAction {

    /** 変遷照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object transId = postJson.get("transId");
        if (transId == null) {
            transId = postJson.get("Tb3Trans.transId");
        }
        if (transId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb3Trans tb3Trans = Tb3Trans.get(transId);
            // 子
            tb3Trans.referTb3TransHiss();
            map.put("Tb3Trans", tb3Trans);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
