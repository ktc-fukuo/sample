package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * ID連番マスタ照会
 *
 * @author emarfkrow
 */
public class M04IdbnGetAction extends BaseAction {

    /** ID連番マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idbnId = postJson.get("idbnId");
        if (idbnId == null) {
            idbnId = postJson.get("M04Idbn.idbnId");
        }
        if (idbnId == null) {
            isAllKey = false;
        }

        Object idbnBn = postJson.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = postJson.get("M04Idbn.idbnBn");
        }
        if (idbnBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M04Idbn m04Idbn = M04Idbn.get(idbnId, idbnBn);
            map.put("M04Idbn", m04Idbn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
