package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Mb5Ref1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * マスタ参照１照会
 *
 * @author emarfkrow
 */
public class Mb5Ref1GetAction extends BaseAction {

    /** マスタ参照１照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object ref1Id = postJson.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = postJson.get("Mb5Ref1.ref1Id");
        }
        if (ref1Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Mb5Ref1 mb5Ref1 = Mb5Ref1.get(ref1Id);
            map.put("Mb5Ref1", mb5Ref1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
