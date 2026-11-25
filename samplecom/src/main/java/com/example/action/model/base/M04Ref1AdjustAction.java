package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Ref1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * マスタ参照１更新
 *
 * @author emarfkrow
 */
public class M04Ref1AdjustAction extends BaseAction {

    /** マスタ参照１更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object ref1Id = form.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = form.get("M04Ref1.ref1Id");
        }
        if (ref1Id == null) {
            throw new OptLockError("error.cant.adjust", "マスタ参照１");
        }

        M04Ref1 e = FormValidator.toBean(M04Ref1.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "マスタ参照１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
