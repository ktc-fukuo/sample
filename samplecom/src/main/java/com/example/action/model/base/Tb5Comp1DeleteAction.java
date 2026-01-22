package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Comp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合１削除
 *
 * @author emarfkrow
 */
public class Tb5Comp1DeleteAction extends BaseAction {

    /** 複合１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object ref1Id = postJson.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = postJson.get("Tb5Comp1.ref1Id");
        }
        if (ref1Id == null) {
            throw new OptLockError("error.cant.delete", "複合１");
        }
        Object ref2Id = postJson.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = postJson.get("Tb5Comp1.ref2Id");
        }
        if (ref2Id == null) {
            throw new OptLockError("error.cant.delete", "複合１");
        }

        Tb5Comp1 e = FormValidator.toBean(Tb5Comp1.class.getName(), postJson);

        java.util.List<com.example.entity.Tb5Comp2> tb5Comp2s = e.referTb5Comp2s();
        if (tb5Comp2s != null) {
            for (com.example.entity.Tb5Comp2 tb5Comp2 : tb5Comp2s) {

                if (tb5Comp2.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "複合２");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "複合１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
