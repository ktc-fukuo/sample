package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Ref3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * マスタ参照３更新
 *
 * @author emarfkrow
 */
public class M04Ref3AdjustAction extends BaseAction {

    /** マスタ参照３更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object ref3Id = form.get("ref3Id");
        if (ref3Id == null) {
            ref3Id = form.get("M04Ref3.ref3Id");
        }
        if (ref3Id == null) {
            throw new OptLockError("error.cant.adjust", "マスタ参照３");
        }

        M04Ref3 e = FormValidator.toBean(M04Ref3.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "マスタ参照３");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
