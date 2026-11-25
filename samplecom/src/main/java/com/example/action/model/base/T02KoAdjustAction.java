package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Ko;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 子更新
 *
 * @author emarfkrow
 */
public class T02KoAdjustAction extends BaseAction {

    /** 子更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Ko.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.adjust", "子");
        }
        Object koBn = form.get("koBn");
        if (koBn == null) {
            koBn = form.get("T02Ko.koBn");
        }
        if (koBn == null) {
            throw new OptLockError("error.cant.adjust", "子");
        }

        T02Ko e = FormValidator.toBean(T02Ko.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "子");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
