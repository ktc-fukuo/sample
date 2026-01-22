package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Kyosei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 共生照会
 *
 * @author emarfkrow
 */
public class Tb6KyoseiGetAction extends BaseAction {

    /** 共生照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kyoseiId = postJson.get("kyoseiId");
        if (kyoseiId == null) {
            kyoseiId = postJson.get("Tb6Kyosei.kyoseiId");
        }
        if (kyoseiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Kyosei tb6Kyosei = Tb6Kyosei.get(kyoseiId);
            map.put("Tb6Kyosei", tb6Kyosei);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
