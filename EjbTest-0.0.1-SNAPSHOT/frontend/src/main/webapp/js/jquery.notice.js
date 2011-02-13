/**
*	jQuery.noticeAdd() and jQuery.noticeRemove()
*	These functions create and remove growl-like notices
*		
*   Copyright (c) 2009 Tim Benniks
*
*	Permission is hereby granted, free of charge, to any person obtaining a copy
*	of this software and associated documentation files (the "Software"), to deal
*	in the Software without restriction, including without limitation the rights
*	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*	copies of the Software, and to permit persons to whom the Software is
*	furnished to do so, subject to the following conditions:
*
*	The above copyright notice and this permission notice shall be included in
*	all copies or substantial portions of the Software.
*
*	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
*	THE SOFTWARE.
*	
*	@author 	Tim Benniks <tim@timbenniks.com>
* 	@copyright  2009 timbenniks.com
*	@version    $Id: jquery.notice.js 1 2009-01-24 12:24:18Z timbenniks $
**/
(function(jQuery)
{
	jQuery.extend({
		noticeInfoAdd: function(options)
		{
            this.noticeAdd({
                text: options.text,
                caption: options.caption,
                linkCaption: options.linkCaption,
                linkUrl: options.linkUrl,
                stay: options.stay,
                type: 'notice-info'
            });
        },

		noticeWarningAdd: function(options)
		{	
            this.noticeAdd({
                text: options.text,
                caption: options.caption,
                linkCaption: options.linkCaption,
                linkUrl: options.linkUrl,
                stay: options.stay,
                type: 'notice-warning'
            });
        },

		noticeErrorAdd: function(options)
		{	
            this.noticeAdd({
                text: options.text,
                caption: options.caption,
                linkCaption: options.linkCaption,
                linkUrl: options.linkUrl,
                stay: options.stay,
                type: 'notice-error'
            });
        },

        noticeAdd: function(options)
		{	
			var defaults = {
				inEffect: 			{opacity: 'show'},	// in effect
				inEffectDuration: 	600,				// in effect duration in milliseconds
				stayTime: 			5000,				// time in milliseconds before the item has to disappear
                caption:            '',                 // caption of the item
				text: 				'',					// content of the item
				linkCaption: 		null,				// link caption, null by default
				linkUrl: 			null,				// link url, null by default
				stay: 				false,				// should the notice item stay or not?
				type: 				'notice' 			// could also be error, success
			}
			

            var timedRemoval = function() {
                if(!options.stay)
                {
                    noticeTimer = setTimeout(function()
                    {
                        jQuery.noticeRemove(noticeItemInner);
                    }, options.stayTime);
                }
            }

            var pauseTimer = function() {
                if(!options.stay)
                {
                    clearTimeout(noticeTimer);
                }
            }
            
            var hasValue = function(obj) {
    			return obj !== null && obj !== undefined; 
    		}
               
            options = jQuery.extend({}, defaults, options);


            var messageBody;
            if (options.caption.length != 0)
            {
                messageBody = '<div class="notice-item-title">'+options.caption+'</div>'+options.text;
            }  else {
                messageBody = options.text;
            }

            if( hasValue(options.linkUrl) && hasValue(options.linkCaption) ){
            	messageBody += '<form class="notice-item-form" method="post" target="main" action="'+
            	options.linkUrl + '"><a name="notice-item-link" class="notice-item-link" href="#" onclick="jQuery(this).parent().submit(); return false;">' + options.linkCaption + '</a></form>';
            }

			// declare variables
			var noticeWrapAll, noticeItemOuter, noticeItemInner, noticeItemClose;
            var noticeTimer;


			noticeWrapAll	= (!jQuery('.notice-wrap').length) ? jQuery('<div></div>').addClass('notice-wrap').appendTo('body') : jQuery('.notice-wrap');
			noticeItemOuter	= jQuery('<div></div>').addClass('notice-item-wrapper');
            noticeItemInner	= jQuery('<div></div>').hide().addClass('notice-item ' + options.type).prependTo(noticeWrapAll).html('<div class="notice-item-body">'+messageBody+'</div>').animate(options.inEffect, options.inEffectDuration).wrap(noticeItemOuter).mouseover(function() { pauseTimer() }).mouseleave(function() { timedRemoval() });
			noticeItemClose	= jQuery('<div></div>').addClass('notice-item-close').prependTo(noticeItemInner).click(function() { jQuery.noticeRemove(noticeItemInner) });
			noticeItemCloseImage = jQuery('<img src="webuif/images/close_balloon_16.png" />').prependTo(noticeItemClose).mouseover(function() { jQuery(this).attr("src", "webuif/images/close_balloon_mouseover_16.png"); }).mouseout(function() { jQuery(this).attr("src", "webuif/images/close_balloon_16.png"); });			
			                                                                                                                
			
			timedRemoval();
		},

		noticeRemove: function(obj)
		{
			obj.animate({opacity: '0'}, 600, function()
			{
				obj.parent().animate({height: '1px'}, 300, function()
				{
					obj.parent().remove();
				});
			});
		}
	});
})(jQuery);