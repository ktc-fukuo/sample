package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２更新
 *
 * @author emarfkrow
 */
public class T07Derive2AdjustAction extends BaseAction {

    /** 派生２更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object derive2Id = form.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = form.get("T07Derive2.derive2Id");
        }
        if (derive2Id == null) {
            throw new OptLockError("error.cant.adjust", "派生２");
        }

        T07Derive2 e = FormValidator.toBean(T07Derive2.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "派生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
