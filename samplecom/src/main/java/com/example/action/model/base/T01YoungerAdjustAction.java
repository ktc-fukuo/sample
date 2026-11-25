package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Younger;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 弟更新
 *
 * @author emarfkrow
 */
public class T01YoungerAdjustAction extends BaseAction {

    /** 弟更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object broId = form.get("broId");
        if (broId == null) {
            broId = form.get("T01Younger.broId");
        }
        if (broId == null) {
            throw new OptLockError("error.cant.adjust", "弟");
        }

        T01Younger e = FormValidator.toBean(T01Younger.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "弟");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
