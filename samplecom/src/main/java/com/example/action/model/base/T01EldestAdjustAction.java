package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Eldest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 長兄更新
 *
 * @author emarfkrow
 */
public class T01EldestAdjustAction extends BaseAction {

    /** 長兄更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object broId = form.get("broId");
        if (broId == null) {
            broId = form.get("T01Eldest.broId");
        }
        if (broId == null) {
            throw new OptLockError("error.cant.adjust", "長兄");
        }

        T01Eldest e = FormValidator.toBean(T01Eldest.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "長兄");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
