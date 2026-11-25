package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Reborn3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生３更新
 *
 * @author emarfkrow
 */
public class T12Reborn3AdjustAction extends BaseAction {

    /** 転生３更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object reborn3Id = form.get("reborn3Id");
        if (reborn3Id == null) {
            reborn3Id = form.get("T12Reborn3.reborn3Id");
        }
        if (reborn3Id == null) {
            throw new OptLockError("error.cant.adjust", "転生３");
        }

        T12Reborn3 e = FormValidator.toBean(T12Reborn3.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "転生３");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
