package com.example.socks.service;

import com.example.socks.model.Socks;
import com.example.socks.repository.SocksRepository;
import org.springframework.stereotype.Service;

@Service
public class SocksService {
    private SocksRepository socksRepository;
    public Integer getSocks (String color, String operation, Integer cottonPart) {
        validateCottonPart(cottonPart);
        Integer socksCount = 0;
        switch (operation) {
            case "moreThan":
                socksCount+= socksRepository.getCottonPartMoreThen(color,cottonPart);
                break;
            case "lessThan":
                socksCount+= socksRepository.getCottonPartLessThen(color,cottonPart);
                break;
            case "equal":
                socksCount+= socksRepository.getCottonPartEqual(color,cottonPart);
                break;
            default:
                throw new RuntimeException("не указано значение количества хлопка в составе носков, одно значение из: moreThan, lessThan, equal;");
        }
        return socksCount;
    }

    public Socks incomeSocks (Socks socks) {
        validateQuantity(socks.getQuantity());
        validateCottonPart(socks.getCottonPart());

        Socks findSocks = socksRepository.findByColorAndCottonPart(
                socks.getColor(),
                socks.getCottonPart());
        if (findSocks != null) {
            findSocks.setQuantity(findSocks.getQuantity() + socks.getQuantity());
        }
        socksRepository.save(socks);
        return socks;
    }

    public Socks outcomeSocks (Socks socks) {
        validateQuantity(socks.getQuantity());
        validateCottonPart(socks.getCottonPart());

        Socks findSocks = socksRepository.findByColorAndCottonPart(
                socks.getColor(),
                socks.getCottonPart());
        if (findSocks != null) {
            findSocks.setQuantity(findSocks.getQuantity() - socks.getQuantity());
        }
        socksRepository.save(socks);
        return socks;
    }

    private void validateCottonPart(Integer cottonPart) {
        if (cottonPart < 0 || cottonPart > 100) {
            throw new RuntimeException("invalid cottonPart value");
        }
    }

    private void validateQuantity(Integer quantity) {
        if (quantity < 1) {
            throw new RuntimeException("invalid quality value");
        }
    }
}
