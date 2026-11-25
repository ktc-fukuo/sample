package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Foster;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 里子更新
 *
 * @author emarfkrow
 */
public class T01FosterAdjustAction extends BaseAction {

    /** 里子更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object broId = form.get("broId");
        if (broId == null) {
            broId = form.get("T01Foster.broId");
        }
        if (broId == null) {
            throw new OptLockError("error.cant.adjust", "里子");
        }

        T01Foster e = FormValidator.toBean(T01Foster.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "里子");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
