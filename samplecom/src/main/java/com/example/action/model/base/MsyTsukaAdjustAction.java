package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyTsuka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 通貨マスタ更新
 *
 * @author emarfkrow
 */
public class MsyTsukaAdjustAction extends BaseAction {

    /** 通貨マスタ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object tsukaKb = form.get("tsukaKb");
        if (tsukaKb == null) {
            tsukaKb = form.get("MsyTsuka.tsukaKb");
        }
        if (tsukaKb == null) {
            throw new OptLockError("error.cant.adjust", "通貨マスタ");
        }
        Object tekiyoBi = form.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = form.get("MsyTsuka.tekiyoBi");
        }
        if (tekiyoBi == null) {
            throw new OptLockError("error.cant.adjust", "通貨マスタ");
        }

        MsyTsuka e = FormValidator.toBean(MsyTsuka.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "通貨マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
