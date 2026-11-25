package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Ref2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * マスタ参照２更新
 *
 * @author emarfkrow
 */
public class M04Ref2AdjustAction extends BaseAction {

    /** マスタ参照２更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object ref2Id = form.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = form.get("M04Ref2.ref2Id");
        }
        if (ref2Id == null) {
            throw new OptLockError("error.cant.adjust", "マスタ参照２");
        }

        M04Ref2 e = FormValidator.toBean(M04Ref2.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "マスタ参照２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
