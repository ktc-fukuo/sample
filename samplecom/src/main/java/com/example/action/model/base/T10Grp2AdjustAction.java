package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Grp2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集団２更新
 *
 * @author emarfkrow
 */
public class T10Grp2AdjustAction extends BaseAction {

    /** 集団２更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object grp2Id = form.get("grp2Id");
        if (grp2Id == null) {
            grp2Id = form.get("T10Grp2.grp2Id");
        }
        if (grp2Id == null) {
            throw new OptLockError("error.cant.adjust", "集団２");
        }

        T10Grp2 e = FormValidator.toBean(T10Grp2.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "集団２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
