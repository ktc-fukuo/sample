package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T11Prev2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世２更新
 *
 * @author emarfkrow
 */
public class T11Prev2AdjustAction extends BaseAction {

    /** 前世２更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object prev2Id = form.get("prev2Id");
        if (prev2Id == null) {
            prev2Id = form.get("T11Prev2.prev2Id");
        }
        if (prev2Id == null) {
            throw new OptLockError("error.cant.adjust", "前世２");
        }

        T11Prev2 e = FormValidator.toBean(T11Prev2.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "前世２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
