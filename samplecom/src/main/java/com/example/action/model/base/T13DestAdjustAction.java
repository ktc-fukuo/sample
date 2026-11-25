package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T13Dest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変換先更新
 *
 * @author emarfkrow
 */
public class T13DestAdjustAction extends BaseAction {

    /** 変換先更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object destId = form.get("destId");
        if (destId == null) {
            destId = form.get("T13Dest.destId");
        }
        if (destId == null) {
            throw new OptLockError("error.cant.adjust", "変換先");
        }

        T13Dest e = FormValidator.toBean(T13Dest.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "変換先");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
