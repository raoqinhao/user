package com.hh.userservice.design.chainofresponsibility;

import java.util.LinkedList;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        ChainFilter chainFilters = new ChainFilter();
        chainFilters.add(new MoneyFilter());
        chainFilters.add(new BarFilter());
        chainFilters.add(new ColorFilter());
        chainFilters.doFilter(null,null);
    }

}

class ChainFilter {

    LinkedList<Filter> listFilter = new LinkedList<>();

    public ChainFilter add(Filter filter) {
        listFilter.add(filter);
        return this;
    }

    public Filter hasNextFilter() {
        if (listFilter.size() > 0) {
            return listFilter.pop();
        }
        return null;
    }

    public boolean doFilter(Request request, Response response) {
        Filter filter = hasNextFilter();
        if (filter != null) {
            filter.doFilter(request,response,this);
        }
        return false;
    }
}


interface Filter {
    boolean doFilter(Request request, Response response, ChainFilter chainFilter);
}

class ColorFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, ChainFilter chainFilter) {
        System.out.println("ColorRequestFilter");
        chainFilter.doFilter(request,response);
        System.out.println("ColorResponseFilter");
        return false;
    }
}

class BarFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, ChainFilter chainFilter) {
        System.out.println("BarRequestFilter");
        chainFilter.doFilter(request,response);
        System.out.println("BarResponseFilter");
        return false;
    }
}

class MoneyFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, ChainFilter chainFilter) {
        System.out.println("MoneyRequestFilter");
        chainFilter.doFilter(request,response);
        System.out.println("MoneyResponseFilter");
        return false;
    }
}


class Request {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Response {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}