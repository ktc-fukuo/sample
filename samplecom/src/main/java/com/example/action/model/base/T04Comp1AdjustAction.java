package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T04Comp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合１更新
 *
 * @author emarfkrow
 */
public class T04Comp1AdjustAction extends BaseAction {

    /** 複合１更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object ref1Id = form.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = form.get("T04Comp1.ref1Id");
        }
        if (ref1Id == null) {
            throw new OptLockError("error.cant.adjust", "複合１");
        }
        Object ref2Id = form.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = form.get("T04Comp1.ref2Id");
        }
        if (ref2Id == null) {
            throw new OptLockError("error.cant.adjust", "複合１");
        }

        T04Comp1 e = FormValidator.toBean(T04Comp1.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "複合１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
