# encoding: UTF-8
# language: en
# Created by lucas at 13/09/2021

@login
Feature: Ton Access - Login and Logout

  @functional
  Scenario: Perform success login using valid credential
    Given I want to access Ton app
    And I access Login option
    And I fill the username and password with valid credentials
    When I click in the Enter button
    Then I must have access to 'Ver extrato' action
#    And I must have access to 'Vender agora' action
#    And I must have access to 'Minhas vendas' action
#    And I must have access to 'Transferir dinheiro' action
#    And I must have access to 'Calculadora de taxas' action
#    And I must have access to 'Links de pagamento' action
#    And I must have access to 'Meu cartão' action
#    And I must have access to 'Minha loja' action
#    And I must have access to 'Renda extra' action
#    And I must have access to 'Empréstimo' action

  @smoke
  Scenario: Perform access to login by create account action
    Given I want to access Ton app
    When I access Create Account option
    Then The question 'Você já é cliente Stone Mais?' to identify Stone Mais customer is displayed
    And The option to access register screen is enabled
    And The option to access login screen is performed with success


  @smoke
  Scenario Outline: Perform unsuccess login using invalid data to filled the fields
    Given I want to access Ton app
    And I access Login option
    And I fill the username <email> and password <password>
    When I click in the Enter button
    Then The page highlight the email field as invalid with the message '<error>'
    And No error message must be displayed

    Examples:
      | email              | password          | error           |
      | ton                | otherpwd          | Email inválido  |

  @smoke
  Scenario Outline: Perform unsuccess login using invalid credential
    Given I want to access Ton app
    And I access Login option
    And I fill the username <email> and password <password>
    When I click in the Enter button
    Then Error message must be displayed
    And An error message '<error_message>' is displayed with title '<title>'
    And The confirmation button is pressed

    Examples:
      | email                 | password          | title      | error_message             |
      | ton@invalid.com.br    | invalid!@invalid  | Erro       | Email ou senha incorretos |
      | DEFAULT               | invalid!@invalid  | Erro       | Email ou senha incorretos |
      | ton@invalid.com.br    | DEFAULT           | Erro       | Email ou senha incorretos |