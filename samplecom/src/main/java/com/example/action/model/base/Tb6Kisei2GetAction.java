package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Kisei2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 寄生照会
 *
 * @author emarfkrow
 */
public class Tb6Kisei2GetAction extends BaseAction {

    /** 寄生照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kisei2Id = postJson.get("kisei2Id");
        if (kisei2Id == null) {
            kisei2Id = postJson.get("Tb6Kisei2.kisei2Id");
        }
        if (kisei2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Kisei2 tb6Kisei2 = Tb6Kisei2.get(kisei2Id);
            map.put("Tb6Kisei2", tb6Kisei2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
