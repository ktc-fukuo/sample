package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 親更新
 *
 * @author emarfkrow
 */
public class T02OyaAdjustAction extends BaseAction {

    /** 親更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Oya.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.adjust", "親");
        }

        T02Oya e = FormValidator.toBean(T02Oya.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "親");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
