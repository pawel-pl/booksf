function showNormal(text, title, linkCaption, linkUrl, stay) {
    stay = typeof(stay) != 'undefined' ? stay : false;

    top.jQuery.noticeAdd({
        text: text,
        caption: title,
        linkCaption: linkCaption,
        linkUrl: linkUrl,
        stay: stay
    });
}

function showInfo(text, title, linkCaption, linkUrl, stay) {
    stay = typeof(stay) != 'undefined' ? stay : false;

    top.jQuery.noticeInfoAdd({
        text: text,
        caption: title,
        linkCaption: linkCaption,
        linkUrl: linkUrl,
        stay: stay
    });
}

function showWarning(text, title, linkCaption, linkUrl, stay) {
    stay = typeof(stay) != 'undefined' ? stay : false;

    top.jQuery.noticeWarningAdd({
        text: text,
        caption: title,
        linkCaption: linkCaption,
        linkUrl: linkUrl,
        stay: stay
    });
}

function showError(text, title, linkCaption, linkUrl, stay) {
    stay = typeof(stay) != 'undefined' ? stay : false;

    top.jQuery.noticeErrorAdd({
        text: text,
        caption: title,
        linkCaption: linkCaption,
        linkUrl: linkUrl,
        stay: stay
    });
}

