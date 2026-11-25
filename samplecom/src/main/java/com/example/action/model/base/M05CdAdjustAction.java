package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Cd;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * CDマスタ更新
 *
 * @author emarfkrow
 */
public class M05CdAdjustAction extends BaseAction {

    /** CDマスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object cdrefCd = form.get("cdrefCd");
        if (cdrefCd == null) {
            cdrefCd = form.get("M05Cd.cdrefCd");
        }
        if (cdrefCd == null) {
            throw new OptLockError("error.cant.adjust", "CDマスタ");
        }

        M05Cd e = FormValidator.toBean(M05Cd.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "CDマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
