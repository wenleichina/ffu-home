package com.funzuqiu.ffu.home.common.thymeleaf.pager;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.funzuqiu.commons.mapper.JsonMapper;
import com.funzuqiu.ffu.home.common.persistence.Page;

public class PagerElementTagProcessor extends AbstractElementTagProcessor {

    private static final String TAG_NAME = "page";
    private static final int PRECEDENCE = 10000;

    private final int first = 1;

    public PagerElementTagProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, // This processor will apply only to HTML mode
                dialectPrefix, // Prefix to be applied to name for matching
                TAG_NAME, // Tag name: match specifically this tag
                true, // Apply dialect prefix to tag name
                null, // No attribute name: will match by tag name
                false, // No prefix to be applied to attribute name
                PRECEDENCE // Precedence (inside dialect's own precedenct)
        );
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
            IElementTagStructureHandler structureHandler) {

        final String pageJson = tag.getAttributeValue("page");
        final Page<?> page = parsePage(pageJson);
        if (page == null) {
            structureHandler.removeElement();
            return;
        }

        final int pageNum = page.getPageNum();
        final int last = page.getPages();
        final String url = tag.getAttributeValue("url");
        if (pageNum <= 0 || last <= 1 || pageNum > last || StringUtils.isBlank(url)) {
            structureHandler.removeElement();
            return;
        }

        final String separator = url.contains("?") ? (url.endsWith("?") ? "" : "&") : "?";
        final int prev = pageNum > first ? pageNum - 1 : first;
        final int next = pageNum < last ? pageNum + 1 : last;

        StringBuilder sb = new StringBuilder();
        sb.append("<ul class=\"pager\">");

        if (pageNum > first) {
            sb.append("<li><a href=\"" + url + separator + "pageNum=" + prev + "\">上一页</a></li>");
        }

        if (pageNum < last) {
            sb.append("<li><a href=\"" + url + separator + "pageNum=" + next + "\">下一页</a></li>");
        }

        sb.append("</ul>");

        structureHandler.replaceWith(sb.toString(), false);
    }

    private Page<?> parsePage(String pageJson) {
        if (StringUtils.isBlank(pageJson)) {
            return null;
        }
        return JsonMapper.fromJson(StringEscapeUtils.unescapeHtml4(pageJson), Page.class);
    }

}
