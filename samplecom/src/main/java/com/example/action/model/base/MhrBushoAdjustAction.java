package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrBusho;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 部署マスタ更新
 *
 * @author emarfkrow
 */
public class MhrBushoAdjustAction extends BaseAction {

    /** 部署マスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object bushoId = form.get("bushoId");
        if (bushoId == null) {
            bushoId = form.get("MhrBusho.bushoId");
        }
        if (bushoId == null) {
            throw new OptLockError("error.cant.adjust", "部署マスタ");
        }

        MhrBusho e = FormValidator.toBean(MhrBusho.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "部署マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
