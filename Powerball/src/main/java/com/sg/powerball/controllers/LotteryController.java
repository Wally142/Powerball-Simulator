package com.sg.powerball.controllers;

import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import com.sg.powerball.service.LotteryService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/lottery")
    public String lottery(Model model) {

        LocalDate drawingdate = LocalDate.now();
        LottoNumber numbers = lotteryService.generateNumbers();

        model.addAttribute("numbers", numbers);
        model.addAttribute("date", drawingdate);

        return "lottery";
    }

    @PostMapping("/lottery")
    public String lotteryResults(LottoNumber num, Model model) {

        LocalDate drawingdate = LocalDate.now();
        LottoNumber numbers = lotteryService.storeNumbers(num, drawingdate);
        List<Purchase> ticket = lotteryService.findWinners(num, drawingdate);

        model.addAttribute("numbers", num);
        model.addAttribute("result", ticket);

        return "lottery";
    }

    @GetMapping("/purchase")
    public String purchase(Model model) {

        LottoNumber test = lotteryService.generateNumbers();
        model.addAttribute("randomNum", test);
        model.addAttribute("purchase", new Purchase());
        return "purchase";
    }

    @PostMapping("/purchase")
    public String buyTicket(@Valid Purchase purchase, BindingResult result, Model model, String action) {

        if (action.equals("quick")) {
            LottoNumber num = lotteryService.generateNumbers();
            model.addAttribute("randomNum", num);

            if (result.hasErrors()) {
                model.addAttribute("purchase", purchase);
                return "purchase";
            } else {
                purchase.setQuickpick(true);
                lotteryService.saveTicket(purchase);
                return "purchase";
            }
        } else if (action.equals("man")) {

            if (result.hasErrors()) {
                LottoNumber test = new LottoNumber();
                model.addAttribute("purchase", purchase);
                model.addAttribute("randomNum", test);
                return "purchase";
            } else {
                lotteryService.saveTicket(purchase);
            }
        }
        return "purchase";
    }

    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    @PostMapping("/search")
    public String findLottoTicket(String lastname, String state, Model model) {

        List<Purchase> ticket = lotteryService.findTicket(lastname, state);
        model.addAttribute("result", ticket);
        return "search";
    }

}
