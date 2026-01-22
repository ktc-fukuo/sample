package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb3TransHis;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 変遷履歴照会
 *
 * @author emarfkrow
 */
public class Tb3TransHisGetAction extends BaseAction {

    /** 変遷履歴照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object transId = postJson.get("transId");
        if (transId == null) {
            transId = postJson.get("Tb3TransHis.transId");
        }
        if (transId == null) {
            isAllKey = false;
        }

        Object transBn = postJson.get("transBn");
        if (transBn == null) {
            transBn = postJson.get("Tb3TransHis.transBn");
        }
        if (transBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb3TransHis tb3TransHis = Tb3TransHis.get(transId, transBn);
            map.put("Tb3TransHis", tb3TransHis);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
