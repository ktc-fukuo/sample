package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrShokuiNinka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 認可マスタ更新
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaAdjustAction extends BaseAction {

    /** 認可マスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object bushoId = form.get("bushoId");
        if (bushoId == null) {
            bushoId = form.get("MhrShokuiNinka.bushoId");
        }
        if (bushoId == null) {
            throw new OptLockError("error.cant.adjust", "認可マスタ");
        }
        Object shokuiId = form.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = form.get("MhrShokuiNinka.shokuiId");
        }
        if (shokuiId == null) {
            throw new OptLockError("error.cant.adjust", "認可マスタ");
        }
        Object tableRe = form.get("tableRe");
        if (tableRe == null) {
            tableRe = form.get("MhrShokuiNinka.tableRe");
        }
        if (tableRe == null) {
            throw new OptLockError("error.cant.adjust", "認可マスタ");
        }

        MhrShokuiNinka e = FormValidator.toBean(MhrShokuiNinka.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "認可マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
