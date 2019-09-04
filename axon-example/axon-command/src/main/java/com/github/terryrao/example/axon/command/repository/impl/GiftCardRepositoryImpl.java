package com.github.terryrao.example.axon.command.repository.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.terryrao.example.axon.command.domain.GiftCard;
import com.github.terryrao.example.axon.command.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raow date: 2019/9/4 19:04
 */
@Service
public class GiftCardRepositoryImpl implements GiftCardRepository {
    @Autowired
    private BaseMapper<GiftCard> baseMapper;

    @Override
    public GiftCard findById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void save(GiftCard giftCard) {
        this.baseMapper.insert(giftCard);
    }

    @Override
    public void update(GiftCard giftCard) {
        this.baseMapper.updateById(giftCard);
    }
}
