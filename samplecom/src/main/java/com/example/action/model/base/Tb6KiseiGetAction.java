package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Kisei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 寄生照会
 *
 * @author emarfkrow
 */
public class Tb6KiseiGetAction extends BaseAction {

    /** 寄生照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kiseiId = postJson.get("kiseiId");
        if (kiseiId == null) {
            kiseiId = postJson.get("Tb6Kisei.kiseiId");
        }
        if (kiseiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Kisei tb6Kisei = Tb6Kisei.get(kiseiId);
            map.put("Tb6Kisei", tb6Kisei);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
