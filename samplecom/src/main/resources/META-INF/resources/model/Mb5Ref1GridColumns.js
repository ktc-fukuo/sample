/**
 * マスタ参照１グリッド定義
 */

let Mb5Ref1GridColumns = [];

$(function() {
    Mb5Ref1GridColumns = [
        Column.text('REF1_ID', Messages['Mb5Ref1Grid.ref1Id'], 90, 'primaryKey numbering', null),
        Column.text('REF1_MEI', Messages['Mb5Ref1Grid.ref1Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['Mb5Ref1Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['Mb5Ref1Grid.tekiyoBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['Mb5Ref1Grid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['Mb5Ref1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
