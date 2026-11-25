package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T13Src;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変換元更新
 *
 * @author emarfkrow
 */
public class T13SrcAdjustAction extends BaseAction {

    /** 変換元更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object srcId = form.get("srcId");
        if (srcId == null) {
            srcId = form.get("T13Src.srcId");
        }
        if (srcId == null) {
            throw new OptLockError("error.cant.adjust", "変換元");
        }

        T13Src e = FormValidator.toBean(T13Src.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "変換元");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
