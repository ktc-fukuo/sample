package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Unique;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ユニークキー更新
 *
 * @author emarfkrow
 */
public class T00UniqueAdjustAction extends BaseAction {

    /** ユニークキー更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object dMei = form.get("dMei");
        if (dMei == null) {
            dMei = form.get("T00Unique.dMei");
        }
        if (dMei == null) {
            throw new OptLockError("error.cant.adjust", "ユニークキー");
        }
        Object eMei = form.get("eMei");
        if (eMei == null) {
            eMei = form.get("T00Unique.eMei");
        }
        if (eMei == null) {
            throw new OptLockError("error.cant.adjust", "ユニークキー");
        }

        T00Unique e = FormValidator.toBean(T00Unique.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "ユニークキー");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
