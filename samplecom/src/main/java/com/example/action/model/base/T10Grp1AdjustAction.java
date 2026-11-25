package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Grp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集団１更新
 *
 * @author emarfkrow
 */
public class T10Grp1AdjustAction extends BaseAction {

    /** 集団１更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object grp1Id = form.get("grp1Id");
        if (grp1Id == null) {
            grp1Id = form.get("T10Grp1.grp1Id");
        }
        if (grp1Id == null) {
            throw new OptLockError("error.cant.adjust", "集団１");
        }

        T10Grp1 e = FormValidator.toBean(T10Grp1.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "集団１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
