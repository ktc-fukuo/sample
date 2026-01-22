/**
 * マスタ参照３グリッド定義
 */

let Mb5Ref3GridColumns = [];

$(function() {
    Mb5Ref3GridColumns = [
        Column.text('REF3_ID', Messages['Mb5Ref3Grid.ref3Id'], 90, 'primaryKey numbering', null),
        Column.text('REF3_MEI', Messages['Mb5Ref3Grid.ref3Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['Mb5Ref3Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['Mb5Ref3Grid.tekiyoBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['Mb5Ref3Grid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['Mb5Ref3Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
