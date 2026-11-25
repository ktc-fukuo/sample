package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ID連番マスタ更新
 *
 * @author emarfkrow
 */
public class M05IdbnAdjustAction extends BaseAction {

    /** ID連番マスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object idrefId = form.get("idrefId");
        if (idrefId == null) {
            idrefId = form.get("M05Idbn.idrefId");
        }
        if (idrefId == null) {
            throw new OptLockError("error.cant.adjust", "ID連番マスタ");
        }
        Object idbnBn = form.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = form.get("M05Idbn.idbnBn");
        }
        if (idbnBn == null) {
            throw new OptLockError("error.cant.adjust", "ID連番マスタ");
        }

        M05Idbn e = FormValidator.toBean(M05Idbn.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "ID連番マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
