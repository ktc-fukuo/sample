package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyKbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 区分マスタ更新
 *
 * @author emarfkrow
 */
public class MsyKbnAdjustAction extends BaseAction {

    /** 区分マスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kbnNm = form.get("kbnNm");
        if (kbnNm == null) {
            kbnNm = form.get("MsyKbn.kbnNm");
        }
        if (kbnNm == null) {
            throw new OptLockError("error.cant.adjust", "区分マスタ");
        }

        MsyKbn e = FormValidator.toBean(MsyKbn.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "区分マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
