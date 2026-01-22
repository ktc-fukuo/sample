package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Mb4Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * IDマスタ照会
 *
 * @author emarfkrow
 */
public class Mb4IdGetAction extends BaseAction {

    /** IDマスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object refId = postJson.get("refId");
        if (refId == null) {
            refId = postJson.get("Mb4Id.refId");
        }
        if (refId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Mb4Id mb4Id = Mb4Id.get(refId);
            // 子
            mb4Id.referMb4Idbns();
            map.put("Mb4Id", mb4Id);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
