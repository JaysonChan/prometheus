package com.web.service;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.analyser.AnalyseTask;
import com.web.analyser.AnalyseTaskExecutor;
import com.web.analyser.Analyser;
import com.web.analyser.AnalyserCrawlerRegister;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 17:01
 * @since v1.0
 */
@Component("AnalyseManagerImpl")
public class AnalyseServiceImpl implements AnalyseService {
    @Autowired
    private AnalyserCrawlerRegister register;
    @Autowired
    private SpringFactory factory;
    private AnalyseTaskExecutor executor;

    @Override
    public <T extends Crawler> void analyse(Page page, Class<T> clazz) {
        Analyser analyser = register.getAnalyser(clazz);
        AnalyseTask task = factory.create(AnalyseTask.class);
        executor.execute(task);
    }
}
