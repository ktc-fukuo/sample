package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約更新
 *
 * @author emarfkrow
 */
public class T10SumAdjustAction extends BaseAction {

    /** 集約更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object sumId = form.get("sumId");
        if (sumId == null) {
            sumId = form.get("T10Sum.sumId");
        }
        if (sumId == null) {
            throw new OptLockError("error.cant.adjust", "集約");
        }

        T10Sum e = FormValidator.toBean(T10Sum.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "集約");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
