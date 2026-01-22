package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Comp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 複合１照会
 *
 * @author emarfkrow
 */
public class Tb5Comp1GetAction extends BaseAction {

    /** 複合１照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object ref1Id = postJson.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = postJson.get("Tb5Comp1.ref1Id");
        }
        if (ref1Id == null) {
            isAllKey = false;
        }

        Object ref2Id = postJson.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = postJson.get("Tb5Comp1.ref2Id");
        }
        if (ref2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5Comp1 tb5Comp1 = Tb5Comp1.get(ref1Id, ref2Id);
            // 子
            tb5Comp1.referTb5Comp2s();
            map.put("Tb5Comp1", tb5Comp1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
