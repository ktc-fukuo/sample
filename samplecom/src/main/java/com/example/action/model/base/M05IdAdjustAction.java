package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * IDマスタ更新
 *
 * @author emarfkrow
 */
public class M05IdAdjustAction extends BaseAction {

    /** IDマスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object idrefId = form.get("idrefId");
        if (idrefId == null) {
            idrefId = form.get("M05Id.idrefId");
        }
        if (idrefId == null) {
            throw new OptLockError("error.cant.adjust", "IDマスタ");
        }

        M05Id e = FormValidator.toBean(M05Id.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "IDマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
