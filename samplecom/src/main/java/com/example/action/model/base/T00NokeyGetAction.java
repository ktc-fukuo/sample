package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Nokey;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 主キーなし照会
 *
 * @author emarfkrow
 */
public class T00NokeyGetAction extends BaseAction {

    /** 主キーなし照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object colD = postJson.get("colD");
        if (colD == null) {
            colD = postJson.get("T00Nokey.colD");
        }
        if (colD == null) {
            isAllKey = false;
        }

        Object colE = postJson.get("colE");
        if (colE == null) {
            colE = postJson.get("T00Nokey.colE");
        }
        if (colE == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T00Nokey t00Nokey = T00Nokey.get(colD, colE);
            map.put("T00Nokey", t00Nokey);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
