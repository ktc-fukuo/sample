package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T14Jisseki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 実績更新
 *
 * @author emarfkrow
 */
public class T14JissekiAdjustAction extends BaseAction {

    /** 実績更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kouteiId = form.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = form.get("T14Jisseki.kouteiId");
        }
        if (kouteiId == null) {
            throw new OptLockError("error.cant.adjust", "実績");
        }
        Object jissekiBn = form.get("jissekiBn");
        if (jissekiBn == null) {
            jissekiBn = form.get("T14Jisseki.jissekiBn");
        }
        if (jissekiBn == null) {
            throw new OptLockError("error.cant.adjust", "実績");
        }

        T14Jisseki e = FormValidator.toBean(T14Jisseki.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "実績");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
