package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T14Koutei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 工程更新
 *
 * @author emarfkrow
 */
public class T14KouteiAdjustAction extends BaseAction {

    /** 工程更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kouteiId = form.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = form.get("T14Koutei.kouteiId");
        }
        if (kouteiId == null) {
            throw new OptLockError("error.cant.adjust", "工程");
        }

        T14Koutei e = FormValidator.toBean(T14Koutei.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "工程");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
