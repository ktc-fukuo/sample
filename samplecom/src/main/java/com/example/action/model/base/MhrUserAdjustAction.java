package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrUser;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ユーザマスタ更新
 *
 * @author emarfkrow
 */
public class MhrUserAdjustAction extends BaseAction {

    /** ユーザマスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object userId = form.get("userId");
        if (userId == null) {
            userId = form.get("MhrUser.userId");
        }
        if (userId == null) {
            throw new OptLockError("error.cant.adjust", "ユーザマスタ");
        }

        MhrUser e = FormValidator.toBean(MhrUser.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "ユーザマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
