package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrShokui;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 職位マスタ更新
 *
 * @author emarfkrow
 */
public class MhrShokuiAdjustAction extends BaseAction {

    /** 職位マスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object shokuiId = form.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = form.get("MhrShokui.shokuiId");
        }
        if (shokuiId == null) {
            throw new OptLockError("error.cant.adjust", "職位マスタ");
        }

        MhrShokui e = FormValidator.toBean(MhrShokui.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "職位マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
